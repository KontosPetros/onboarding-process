# Onboarding and VC Creation Process

## Running Steps

### Email Mock Server

1. **Start MailHog Docker Container**:
    - Ensure you have Docker installed on your machine.
    - Use the following command to start the MailHog container:
    ```sh
    docker run -d -p 8025:8025 -p 1025:1025 mailhog/mailhog
    ```
    - This will start MailHog, mapping its web interface to port 8025 and SMTP to port 1025.

2. **Monitor Emails**:
    - Open your web browser and navigate to [http://localhost:8025](http://localhost:8025).
    - This is where you can monitor the emails sent by your application.

### Camunda/Java Spring Application

1. **Run the Application**:
    - Ensure you have the required dependencies and build tools installed (e.g., Maven).
    - In your project directory, use the following command to run your Spring Boot application:
    ```sh
    ./mvnw spring-boot:run
    ```
    - Alternatively, if you're using an IDE like IntelliJ IDEA or Eclipse, you can run the application as a Java application.

2. **Access Camunda's UI**:
    - Open your web browser and navigate to [http://localhost:8080/camunda/](http://localhost:8080/camunda/).
    - Here, you can access the Camunda Tasklist, Cockpit, and Admin interfaces.

3. **Create Participants**:
    - If needed, create the users (participants) with the following IDs and email addresses: `CSP`, `Legal`, `Maintainer`.
    - This can be done via the Camunda Admin interface:
        1. Go to the Admin interface.
        2. Navigate to "Users" and create new users with the specified IDs and email addresses.
            - **CSP**: `csp@example.com`
            - **Legal**: `legal@example.com`
            - **Maintainer**: `maintainer@example.com`
        3. Assign appropriate groups/roles to each user.

4. **Login to Each Participant's Account**:
    - Open different browser windows or use incognito tabs for each participant to avoid session conflicts.
    - Login as `CSP`, `Legal`, and `Maintainer` respectively.

5. **Start the 'CSP' Process**:
    - Using the Camunda Tasklist interface, log in as `CSP`.
    - Start the process instance for the `CSP` process.
    - Follow any prompts or input requirements as defined in your BPMN model.

6. **Monitor Process Steps via Cockpit**:
    - Open the Camunda Cockpit interface by navigating to [http://localhost:8080/camunda/app/cockpit/](http://localhost:8080/camunda/app/cockpit/).
    - Here, you can monitor the progress of the process instance, view task assignments, and inspect execution logs.
