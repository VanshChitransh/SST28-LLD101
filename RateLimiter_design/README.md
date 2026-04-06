# Rate Limiter Design

## Overview
The Rate Limiter is a system designed to control the amount of incoming requests to a resource to ensure the resource is not overwhelmed. This design implements a Rate Limiter using the Strategy Pattern, allowing flexibility in different rate limiting strategies.

## Strategy Pattern Implementation
The Strategy Pattern is a behavioral design pattern that enables selecting an algorithm at runtime. In the context of the Rate Limiter, this allows the implementation of multiple rate limiting strategies:

1. **Fixed Window:** A simple strategy that allows a fixed number of requests within a defined time window.
2. **Sliding Window:** A more sophisticated approach that tracks requests over a sliding time window.
3. **Token Bucket:** This strategy allows a burst of requests while ensuring a steady rate over time.

The implementation can easily switch between these strategies without modifying the core logic of the Rate Limiter.

## Key Features
- **Customizable Rate Limits:** Users can define their rate limits according to specific needs.
- **Real-Time Monitoring:** Provides insights into the current load and rate limit status.
- **Flexible Strategy Selection:** Choose between different rate limiting strategies based on the requirements of the application.
- **Easy Integration:** Designed to be easily integrated with existing applications, minimizing disruption to current workflows.

## Getting Started
To use the Rate Limiter, simply create an instance of the desired strategy and set the required rate limits. Refer to the documentation for detailed examples and usage instructions.

**Class-Design**

<img width="921" height="477" alt="image" src="https://github.com/user-attachments/assets/6375500c-961a-4f18-9426-1fabf7e8f248" />
