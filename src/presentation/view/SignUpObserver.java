package presentation.view;

public interface SignUpObserver {
    /**
     * The user could be created successfully
     */
    void userRegisteredSuccessfully();

    /**
     * The user could not be registered
     */
    void userRegistrationFailed();
}
