# Run Selenium Tests With Selenide


*Learn how to configure and run your Java automation testing scripts on Selenide.*

## Table Of Contents

* [Pre-requisites](#pre-requisites)
* [Cloning Repo](###Cloning-Repo)
* [Testing On Single Browser](###Testing-On-Single-Browser)

## Pre-requisites

Before you can start performing Java automation testing with Selenide, you would need to:

- Install the latest **Java development environment** i.e. **JDK 1.8** or higher. We recommend using the latest version.

- Download the latest **Selenium Client** and its **WebDriver bindings** from the [official website](https://www.selenium.dev/downloads/). Latest versions of Selenium Client and WebDriver are ideal for running your automation script.

- Install **Maven** which supports **JUnit** framework out of the box. **Maven** can be downloaded and installed following the steps from [the official website](https://maven.apache.org/). Maven can also be installed easily on **Linux/MacOS** using [Homebrew](https://brew.sh/) package manager.

### Cloning-Repo
git clone https://github.com/rathsiddharth/SelenideFWK.git

### Testing-On-Single-Browser
- mvn test -P single
