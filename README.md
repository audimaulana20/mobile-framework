# Mobile Automation Framework

Mobile automation framework built with:

* Java 17
* Appium Java Client 9.x
* TestNG
* Maven
* Android Real Device

## Architecture

```text
module
├── login
│   ├── LoginLocator
│   ├── LoginModel
│   ├── LoginPage
│   └── LoginSteps
│
└── payment
    ├── PaymentLocator
    ├── PaymentModel
    ├── PaymentPage
    └── PaymentSteps
```

## Layer Responsibilities

* **Locator** → Store element locators
* **Model** → Store test data
* **Page** → Store page actions
* **Steps** → Feature contract
* **Test** → Test scenario execution

## Locator Priority

1. Resource ID
2. Accessibility ID
3. UiAutomator
4. XPath

## Run Test

```bash
mvn clean test
```

## Author

Audi Maulana
