# Distributed Cache Design

This is a comprehensive implementation of a **Distributed Cache System** that demonstrates key concepts in distributed systems, caching strategies, and load balancing. The system uses multiple cache nodes with LRU eviction policy and supports pluggable distribution strategies.

**Class-Design**

<img width="1163" height="538" alt="image" src="https://github.com/user-attachments/assets/ee6768c6-289c-4a1c-ae0d-a70ebc990b87" />


## Overview

A distributed cache is a system that stores frequently accessed data across multiple nodes to:
- **Reduce latency**: Serve data from cache instead of backend databases
- **Improve throughput**: Handle more concurrent requests
- **Decrease database load**: Minimize expensive database queries
- **Enhance scalability**: Distribute cache across multiple nodes

## Features

### 1. **Multi-Node Caching**
   - Data is distributed across multiple cache nodes
   - Each node maintains its own LRU cache with configurable capacity
   - Reduces memory footprint per node and improves performance

### 2. **LRU (Least Recently Used) Eviction Policy**
   - Implemented using `LinkedHashMap` with access-order tracking
   - Automatically evicts the least recently used item when capacity is exceeded
   - Ensures frequently accessed data remains in cache

### 3. **Pluggable Distribution Strategy**
   - `DistributionStrategy` interface allows different routing algorithms
   - `ModuloStrategy`: Uses hash-based modulo operation for consistent distribution
   - Easy to extend with additional strategies (e.g., Consistent Hashing)

### 4. **Transparent Database Fallback**
   - On cache miss, automatically fetches from database
   - Loaded data is cached for future access
   - Reduces database load over time

## Design Patterns Used

### Strategy Pattern
The distribution of keys to nodes is handled through the `DistributionStrategy` interface, allowing multiple implementation strategies without changing client code.

```java
public interface DistributionStrategy {
    int getNodeIndex(String key, int totalNodes);
}
```

### Template Method Pattern
The `DistributedCache` class provides the overall caching logic while delegating distribution decisions to the strategy.

## Components

### 1. **DistributedCache** (Main Coordinator)
- Manages multiple cache nodes
- Routes requests to appropriate nodes based on distribution strategy
- Handles get/put operations

### 2. **CacheNode**
- Represents a single cache instance
- Encapsulates an LRU cache
- Provides get, put, and contains operations

### 3. **LRUCache** (Local Cache)
- Implements Least Recently Used eviction policy
- Uses `LinkedHashMap` for efficient tracking
- Maintains fixed capacity per node

### 4. **DistributionStrategy** (Interface)
- Defines contract for key-to-node mapping
- Enables pluggable distribution algorithms

### 5. **ModuloStrategy** (Implementation)
- Uses hash code modulo total nodes
- Provides simple and deterministic key distribution
- Formula: `Math.abs(key.hashCode()) % totalNodes`

### 6. **Database** (Fallback Storage)
- Simulates persistent data store
- Used when data is not found in cache

## Strategies Explained

### Modulo Strategy (Hash-Based Distribution)
```
Key Distribution: index = hash(key) % number_of_nodes

Example (3 nodes):
- "A" -> hash("A") % 3 = Node_X
- "B" -> hash("B") % 3 = Node_Y
- "C" -> hash("C") % 3 = Node_Z
```

**Advantages:**
- Simple and fast O(1) computation
- Deterministic routing

**Disadvantages:**
- Poor distribution when nodes are added/removed
- High cache misses during scaling (rehashing required)

**When to use:** Small clusters that rarely change

### Future Strategy Options

**Consistent Hashing:**
- Minimizes key rehashing when nodes are added/removed
- Uses hash ring for improved distribution
- Ideal for dynamic, large-scale systems

**Round Robin:**
- Distributes keys sequentially across nodes
- Good for uniform load distribution
- Less suitable if key frequency varies



## Installation and Running

```bash
# Compile
javac *.java

# Run
java Main
```

## File Structure

```
DistributedCache_design/
├── DistributedCache.java      # Main cache coordinator
├── CacheNode.java              # Individual cache node wrapper
├── LRUCache.java               # LRU cache implementation
├── DistributionStrategy.java   # Strategy interface
├── ModuloStrategy.java         # Hash-based distribution
├── Database.java               # Fallback data source
├── Main.java                   # Demo/test
└── README.md                   # This file
```

## Key Learnings

This design demonstrates:
- **System Design**: Multi-component distributed systems
- **Design Patterns**: Strategy pattern for pluggable algorithms
- **Data Structures**: LRU cache implementation with LinkedHashMap
- **Load Balancing**: Key distribution strategies
- **Caching Concepts**: Hit/miss, eviction policies, capacity management
- **Trade-offs**: Consistency, latency, complexity

## License

This project is provided as an educational resource.
