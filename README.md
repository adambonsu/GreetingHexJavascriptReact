# Greeting Hex Javascript React

[![Build Status](https://github.com/adambonsu/GreetingHexJavascriptReact/actions/workflows/ci-cd.yml/badge.svg)](https://github.com/adambonsu/GreetingHexJavascriptReact/actions/workflows/ci-cd.yml)

## Problem

In a world where loneliness lurks around every corner and technology seems to be both our best friend and worst enemy, people are desperately seeking a simple greeting to brighten their day. With half of adults experiencing the pangs of social isolation, it’s clear that we need a cheerful greeting from a friendly program to remind us that we’re not alone in this vast digital universe.

### Who are our potential Customers?
* What are the target customer segments for the business?
    * Adults experiencing the pangs of social isolation
* Which specific markets/countries the business is trying to expand to?
    * Initially the UK (England, Ireland, Scotland, Wales)
    * Then Europe
    * Then the US
* What are the top OSs and vendors in those markets?
    * UK: https://gs.statcounter.com/vendor-market-share/mobile/united-kingdom
        * Apple, Samsung
    * Europe: https://gs.statcounter.com/vendor-market-share/mobile/europe
        * Apple, Samsung, Xiaomi
    * US: https://gs.statcounter.com/vendor-market-share/mobile/united-states-of-america
        * Apple, Samsung, Google


## Solution 

This is a CI/CD solution whereupon each push to main, builds iOS and android mobile versions, testing against devices that our customers use.


### Test Strategy
```
    * Application
        * Hexagonal architecture
            * Flexible
            * Testable
        * Full Stack Testing 
            * Functional
            * Accessibility
            * Security Testing
            * Performance
    * Device
        * AWS Test Farm
            * Test against most important devices on each commit
    * Network
        * With network
        * Without network
```

## Hexagonal Architecture Overview

Hexagonal Architecture, also known as Ports and Adaptors, is a software design pattern that aims to create loosly coupled application components.
It separates the core logic of an application from its external concerns.

Key components in this architecture are:
1. Core: Contains the main business logic
2. Ports: Interfaces that define how the core interacts with the outside world
3. Adaptors: Implementations of ports that handle external interactions

Benefits of this architecture include:
* Separation of concerns
* Improved testability
* Flexibility to change external components without affecting the core logic


## Full Stack Testing Overview

Full Stack Testing is a comprehensive testing strategy that covers all layers of a software application, including the front-end, back-end, databases, APIs, and infrastructure. This approach ensures that the application works seamlessly from end to end, providing thorough validation of its functionalities, performance, security, and user experience

Key Components of Full Stack Testing:
* Testing for High Quality
* Shift-Left Testing
* All Components (UI, Service Layer, Data Layer) subjected to a stack of test techniques 
   * Exploratory testing
   * Automated Functional testing
   * Continuous testing (CI/CD)
   * Cross Functional testing
   * Visual testing
   * Security testing
   * Performance testing
   * Accessibility testing


## Project Status

### Done
* Mobile app serving a Greeting (react native)
* Test confirming app serves Greeting (java, JUnit) 
* CI/CD Pipeline
    * CI: Build Images
        * IOS: [Archive failing](https://github.com/adambonsu/GreetingHexJavascriptReact/issues/1)
        * Android: Complete
    * CD:
        * Functional test implemented: To be run against IOS and Android apps in AWS Device Farm
        * IOS: [Blocked by Archive failing](https://github.com/adambonsu/GreetingHexJavascriptReact/issues/1)
        * Android: [Configuring automatic device farm deployment and testing - WIP](https://github.com/adambonsu/GreetingHexJavascriptReact/issues/2)


### To do
* Resolve [building iOS image on the pipeline](https://github.com/adambonsu/GreetingHexJavascriptReact/issues/1)
* [Configure react repo to run device tests via aws farm](https://github.com/adambonsu/GreetingHexJavascriptReact/issues/2)
* Refactor core greeting out into javascript library that can be imported into this Mobile UI repository (Hexagonal Architecture)
* [Track production device usage statistics](https://github.com/adambonsu/GreetingHexJavascriptReact/issues/4)
* Implement Automated Performance Tests
* Implement Automated Security Tests
* Implement Automated Accessibility Tests
* [Include a Service Layer (with associated api tests)](https://github.com/adambonsu/GreetingHexJavascriptReact/issues/3)
   * Implement Micro Tests
   * Implement Macro Tests
   * Implement User Flow Tests
* Implement `Without Network` tests
* Implement `With Network` tests

