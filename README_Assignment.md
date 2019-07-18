# Ebay assignment

## Overview
Using Page Object Oriented for web interface. The Ebay pages will store at `interfaces` package. All methods related to particular page are stored in particular page.

![Interface structure](https://imgur.com/Mv9SQBh)

For test class, it's stored under `tests/ebay` package, and testNG xml file are stored under testsuites package.

![Tests file structure](https://imgur.com/gNqAGlj)

## Usage

Please run test directly from testNG xml file. For Ebay assignment, a testNG xml file is `demo_run_single_test_ebay.xml`

# REST API Testing

## Overview

A csv data file stay in `resources` package.

![csv data](https://imgur.com/2FoVrXd)

For REST API there are no interfaces to interact so there is only test class in `tests/google` package.

![google test](https://imgur.com/GoHH2SL)

It also has `Geocoding` class to get latitude and longitude from google api stored at `actions/google`.

![Geocoding](https://imgur.com/OtseAfv)

## Usage

Please run test directly from testNG xml file. For REST API assignment, a testNG xml file is `demo_run_single_test_api.xml`
