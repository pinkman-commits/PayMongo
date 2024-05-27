package com.paymongo.mongopage;

public class PayMongoPagePath {
    //Login Page
    public static final String [] LOGIN_TITLE                   = {"//div//span[contains(text(), 'Log in to PayMongo')]", "'Log in to PayMongo' - Title"};
    public static final String [] EMAIL_ADDRESS_TITLE           = {"//label[contains(text(), 'Email Address')]", "'Email Address' - Title"};
    public static final String [] EMAIL_ADDRESS_FIELD           = {"//input[@placeholder = 'johndoe@domain.com']", "'Email Address' - Field"};
    public static final String [] PASSWORD_TITLE                = {"//label[contains(text(), 'Password')]", "'Password' - Title"};
    public static final String [] PASSWORD_FIELD                = {"//input[@type = 'password' and @name = 'password']", "'Password' - Field"};
  
    public static final String [] FORGOT_YOUR_PASSWORD_LINK     = {"//div//a[contains(text(), 'Forgot your password?')]", "'Forgot your password?' - Link"};
    public static final String [] LOGIN_BUTTON                  = {"//button//div//span[contains(text(), 'Log in')]", "'Log in' - Button"};
    public static final String [] SIGNUP_LINK                   = {"//div//a[@class = 'sign-up']", "'Sign Up Page' - Link"};
    
    public static final String [] PASSWORD_EYE_ICON             = {"//button[@class='password-input']", "'Password Eye Icon' - Button"};
    public static final String [] PASSWORD_MASKED_ICON          = {"//button[@class='password-input']//*[contains(@data-icon,'eye-slash')]", "'Password Masked Icon'"};
    public static final String [] PASSWORD_UNMASKED_ICON        = {"//button[@class='password-input']//*[contains(@data-icon,'eye')]", "'Password Unmasked Icon'"};
    

    //Activate Account Page
    public static final String[] ACTIVATE_ACCOUNT               = {"//li[contains(@class, 'activate')]//*[contains(@class, 'activate-step-counter-container')]//*[contains(text(), 'Activate your account')]", "'Activate your account'"};
    public static final String[] HOME                           = {"//li[contains(@class, 'home')]//*[contains(@class, 'sidebar-item__label') and text()='Home']", "'Home'"};
    public static final String[] LINKS                          = {"//li[contains(@class, 'links')]//*[contains(@class, 'sidebar-item__label') and text()='Links']", "'Links'"};
    public static final String[] PAGES                          = {"//li[contains(@class, 'pages')]//*[contains(@class, 'sidebar-item__label') and text()='Pages']", "'Pages'"};
    public static final String[] PAYMENTS                       = {"//li[contains(@class, 'payments')]//*[contains(@class, 'sidebar-item__label') and text()='Payments']", "'Payments'"};
    public static final String[] PAYOUTS                        = {"//li[contains(@class, 'payouts-v2')]//*[contains(@class, 'sidebar-item__label') and text()='Payouts']", "'Payouts'"};
    public static final String[] DEVELOPERS                     = {"//li[contains(@class, 'developers')]//*[contains(@class, 'sidebar-item__label') and text()='Developers']", "'Developers'"};
    public static final String[] SECURITY_LOGS                  = {"//li[contains(@class, 'security-logs')]//*[contains(@class, 'sidebar-item__label') and text()='Security logs']", "'Security Logs'"};
    public static final String[] SETTINGS                       = {"//li[contains(@class, 'sidebar__settings-submenu')]//*[contains(@class, 'sidebar-item__label') and text()='Settings']", "'Settings'"};
    public static final String[] LIVE_DATA                      = {"//div[contains(@class, 'LiveSwitchComponent')]", "'View live data'"};

    public static final String [] KYC_FORM                      = {"//div[@class = 'kyc-form']", "Activation KYC Form"};
    public static final String [] KYC_STEP_1                    = {"//button[contains(@class, 'Step-item_status_in_progress')]//*[contains(@class, 'Step-item__label') and text()='What is KYC?']", "What is KYC?"};
    public static final String [] KYC_STEP_2                    = {"//button//*[contains(@class, 'Step-item__label') and text()='Identity Verification']", "Identity Verification"};
    public static final String [] KYC_STEP_3                    = {"//button//*[contains(@class, 'Step-item__label') and text()='General Information']", "General Information"};
    public static final String [] KYC_STEP_4                    = {"//button//*[contains(@class, 'Step-item__label') and text()='Business Information']", "Business Information"};
    public static final String [] KYC_STEP_5                    = {"//button//*[contains(@class, 'Step-item__label') and text()='Statement of Acceptance']", "Statement of Acceptance"};









}
