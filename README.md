# Zebrunner Carina reporting agent

## sample-carina-maven

Your guide to run the first Carina test with reporting to Zebrunner.

## Preconditions

Before you can start configuring Zebrunner Carina reporting agent, you need to create a free Zebrunner workspace at https://zebrunner.com/

## Configuration

### _Step 1: Basic project setup_

Clone the Zebrunner's [samples](https://github.com/zebrunner/java-agent-samples) repository and navigate to the code directory as shown below:

```
git clone https://github.com/zebrunner/java-agent-samples.git
cd java-agent-samples/sample-carina-maven
```

### _Step 2: Configure credentials and reporting_

In Zebrunner:

- Navigate to "Account and profile" section by clicking on the User icon from the top right side;
- Click on "API Tokens" tab;
- Press "Token" button, create a token and copy it before closing the dialog (you won't be able to see the token later).

Define launch configuration (override defaults if needed) and copy content below to the `src/main/resources/agent.properties` file.

#### **`agent.properties`**

```
reporting.enabled=true
reporting.project-key=DEF
reporting.server.hostname=https://<workspace>.zebrunner.com/
reporting.server.access-token=<token>
reporting.run.display-name=<display_name>
```

### _Step 3: Configure Selenium WebDriver_

In Zebrunner:

- Navigate to "Automation -> Launches" page by selecting the menu from left sidebar;
- Click on key icon from the top right side on Launches page;
- You will see 'Hub Access' popup where you can copy URL of remote Selenium Grid;
- Set copied value for variable `selenium_url`.

Configure desired capabilities and insert snippet below to `src/main/resources/_config.properties` file.

#### **`_config.properties`**

```
capabilities.platformName=linux
capabilities.browserName=chrome
capabilities.browserVersion=109.0
selenium_url=<selenium_url>
capabilities.enableVideo=true
```

### _Step 4: Execute the tests_

Please run the following command in the terminal.

```
mvn test -Dsuite=basic
```

### _Step 5: View test results_

Congratulations! You have just completed a reporting setup for a test project!
Now you can go to Launches page to see the results.

To learn more about advanced reporting capabilities, supported Selenium Grid providers, test cases mapping and more please go to the [documentation](https://zebrunner.com/documentation/reporting/carina-testng/).