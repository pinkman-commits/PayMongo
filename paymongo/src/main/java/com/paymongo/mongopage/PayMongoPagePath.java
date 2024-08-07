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

    public static final String [] KYC_FORM_NEXT_BUTTON          = {"//button/child::div//span[contains(text(), 'Next')]", "'Next' button"};
    public static final String [] SEE_FULL_LIST_HERE_LINK       = {"//div//span[contains(text(), 'See full list here.')]", "See full list here. link"};
    public static final String [] LIST_OF_VALID_ID_POPUP        = {"//div[@class = 'ant-modal-content']", "List of Valid ID Popup"};
    public static final String [] LIST_OF_PRIMARY_BUTTON        = {"//div//span[contains(text(), 'Primary IDs')]", "List of Primary IDs"};
    public static final String [] LIST_OF_SECONDARY_BUTTON      = {"//div//span[contains(text(), 'Secondary IDs')]", "List of Secondary IDs"};
    public static final String [] CLOSE_POPUP                   = {"//button[@aria-label ='Close']", "Close Button"};

    public static final String [] VERIFY_MY_IDENTITY_BUTTON     = {"//div//span[contains(text(), 'Verify identity')]", "'Verify identity' button"};
    

    public static final String [] VERIFICATION_PAGE             = {"//div//h6[contains(text(), 'Select your type of valid ID')]", "Selection of Valid ID type"};
    public static final String [] SELECT_PRIMARY_ID             = {"//input[@value= 'Primary ID']", "Primary ID RadioButton"};
    public static final String [] CONTINUE_BUTTON               = {"//span[text()='Continue']", "Continue button"};
    

    public static final String [] SELECT_PRIMARYID_TYPE(String value) {
        String xpath = "//input[@type='radio' and @value='" + value + "']";
        String [] pmid = {xpath, "[Primary ID: "+value+"]"};
        return pmid;
    }

    public static final String [] CAPTURE_ID = {"(//button[contains(@class, 'image-capture-button')])[1]", "CAPTURE ID BUTTON"};
    public static final String [] CAPTURE_SELFIE = {"(//button[contains(@class, 'image-capture-button')])[2]", "CAPTURE SELFIE BUTTON"};

    public static final String [] CAMERA_CAPTURE = {"//button[@class = 'MuiButtonBase-root MuiButton-root MuiButton-text']", "Capture Button"};
    public static final String [] SAVE_AND_CONTINUE_BUTTON      = {"//span[text()='Save and Continue']", "Continue button"};
    public static final String [] SUBMIT_BUTTON = {"//span[text()='Submit']", "Submit button"};
    public static final String [] THANK_YOU = {"//h6[text()='Thank you!']", "Thank You Notification"};
    public static final String [] RESULT_PROCESSED = {"//div[contains(text(), 'Result has been processed')]", "Result has been processed"};


    //STEP3 - GENERAL INFO
    public static final String [] CS_NUMBER = {"//input[@id='account.customer_service_number']", "Customer service number"};
    public static final String [] ADDRESS_1 = {"//input[@id='address.line1']", "Line 1 Address"};
    public static final String [] ADDRESS_2 = {"//input[@id='address.line2']", "Line 2 Address"};
    public static final String [] CITY = {"//input[@id='address.city']", "City/Municipality"};
    public static final String [] REGION = {"//div[contains(text(), 'Select region')]", "Region"};
    public static final String [] REGION_VALUE (String value) {
        String xpath = "//div[contains(text(), '"+value+"')]";
        String [] regionid = {xpath, "[REGION: "+value+"]"};
        return regionid;
    }

    public static final String [] SELECT_NO_OF_EMPLOYEE = {"//input[@id='account.business_size']/preceding-sibling::div[contains(text(), 'Select')]", "Select Number of Employee"};
    public static final String [] NO_OF_EMPLOYEE_VALUE(String value){
        String xpath = "//button//div[contains(text(), '"+value+"')]";
        String[] noemployee = {xpath, "[No of Employee]: "+value+""};
        return noemployee;
    }

    public static final String [] SELECT_INDUSRY = {"//business.grab_pay_category']/preceding-sibling::div[contains(text(), 'Select')]", "Region"};
    public static final String [] INDUSTRY_VALUE(String value){
        String xpath = "//button//div[contains(text(), '"+value+"')]";
        String[] industry = {xpath, "[No of Employee]: "+value+""};
        return industry;
    }

    public static final String [] PRODUCT_DESC = {"//textarea[@id='business.description']", "Product description and nature of your business"};
    public static final String [] ONLINE_PRESENCE = {"//input[@placeholder = 'paymongo.com']", "Online Presence"};
    public static final String [] BUSINESS_HANDLE = {"//input[@id = 'business.handle']", "Business Handle"};


    //Step 4

    public static final String[] SOLE_PROPRIETORSHIP = {"//h4[contains(text(), 'Sole proprietorship')]", "Sole Proprietorship"};
    public static final String[] PARTNERSHIP = {"//h4[contains(text(), 'Partnership')]", "Partnership"};
    public static final String[] CORPORATION = {"//h4[contains(text(), 'Corporation')]", "Corporation"};

    //Step 5
    public static final String[] LEGAL_NAME = {"//label[@for='first_name']/input", "Legal name"};
    public static final String[] LAST_NAME = {"//label[@for='last_name']/input", "Last name"};
    public static final String[] DATE_OF_BIRTH = {"//span[@id='date_of_birth']//input", "Date of birth"};
    public static final String[] NATIONALITY = {"//div[contains(text(), 'Select nationality')]", "Nationality"};
    public static final String [] NATIONALITY_VALUE(String value){
        String xpath = "//button//div[contains(text(), '"+value+"')]";
        String[] nationality = {xpath, "[NATIONALITY]: "+value+""};
        return nationality;
    }

    public static final String [] CITY_OF_BIRTH = {"//label[@for='place_of_birth_city']/input", "City of birth"};
    public static final String [] COUNTRY_OF_BIRTH = {"//div[contains(text(), 'Select country of birth')]", "Country of birth"};
    public static final String [] COUNTRY_OF_BIRTH_VALUE(String value){
        String xpath = "//button//div[contains(text(), '"+value+"')]";
        String[] nationality = {xpath, "[Country of Birth]: "+value+""};
        return nationality;
    }
    public static final String[] HOME_ADDRESS_LINE1 = {"//label[@for='line1']/input", "Home address line 1"};
    public static final String[] HOME_ADDRESS_LINE2 = {"//label[@for='line2']/input", "Home address line 2"};
    public static final String[] CITYADDRESS = {"//label[@for='city']/input", "City"};
    public static final String[] POSTAL_CODE = {"//label[@for='postal_code']/input", "Postal code"};


    public static final String[] DTI_REG_NAME = {"//input[@id = 'dti_registered_name']", "DTI-registered business name"};
    public static final String[] HOW_LONG_IN_BUSINESS = {"//div[@class = 'select-value select-value--placeholder']", "How long have you been in business?"};
    public static final String [] HOW_LONG_IN_BUSINESS_VALUE(String value){
        String xpath = "//button//div[contains(text(), '"+value+"')]";
        String[] business = {xpath, "[Country of Birth]: "+value+""};
        return business;
    }

    public static final String [] BUSINESS_TIN = {"//input[@id='tin_number']", "Business tax identification number"};
    public static final String [] SELECT_BANK = {"//div[@class = 'select-value__content' and contains(text(), 'Select bank')]", "Bank"};
    public static final String [] ACCOUNT_NAME = {"//input[@id = 'account_name']", "Account Name"};
    public static final String [] ACCOUNT_NO = {"//input[@id = 'account_number']", "Account Number"};


    //Step 6
    public static final String [] FIRSTNAME = {"//input[@id='dsa.first_name']", "First Name"};
    public static final String [] LASTNAME = {"//input[@id='dsa.last_name']", "Last Name"};
    public static final String [] EMAIL = {"//input[@id='dsa.email']", "Email Address"};

    public static final String [] SELECT_NO_DATA_DISCLOSURE = {"//input[@id='dsa.authorized.false']", "No, I do not intented to disclose Personal Data from PayMongo"};


    public static final String [] DASHBOARDLINK = {"//span[contains(text(), 'Start exploring the Dashboard')]", "Start exploring the Dashboard"};
;}
