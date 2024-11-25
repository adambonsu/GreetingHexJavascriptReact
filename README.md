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
* Track production usage statistics if available
    * feed back this info to inform which devices to use in future tests


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

## Status

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
* Configure react repo to run device tests via aws farm
    * https://github.com/adambonsu/GreetingHexJavascriptReact/issues/2
* Refactor core greeting out into javascript library that can be imported into this Mobile UI repository (Hexagonal Architecture)
* Implement Automated Performance Tests
* Implement Automated Security Tests
* Implement Automated Accessibility Tests
* Include a Service Layer (with associated api tests): https://github.com/adambonsu/GreetingHexJavascriptReact/issues/3
   * Implement Micro Tests
   * Implement Macro Tests
   * Implement User Flow Tests
* Implement Without Network tests
* Implement With Network tests

