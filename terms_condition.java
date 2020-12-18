package com.example.eyes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class terms_condition extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlertDialog.Builder dialog = new AlertDialog.Builder(terms_condition.this);
        dialog.setCancelable(false);
        dialog.setTitle("TERMS AND CONDITIONS");
        dialog.setMessage("By accessing and using this service, you accept and agree to be bound by the terms and provisions of this agreement. In addition, using these particular services you shall be subject to any posted guidelines or rules applicable to such services. Any participation in this service will constitute acceptance of this agreement. If you do not agree to this then please do not use these services.”\n" +
                "Privacy/policy for user info-\n" +
                "The amount of information which we are storing of  the user\n" +
                "1.we are taking personal information such as contact information, password, username if you wish to create an account.\n" +
                "2. Transaction Information: If you decide to upgrade your account to the premium version then we will store all the credit or debit card information, addresses, and other information related to billing or payment transactions in our databases for future references.\n" +
                "3. Client Services: if you decide to contact us for any problems you are facing while using our application we will store the information you give us about the problem and all the mobile information which we will decide is important to understand more about the problem you are facing.\n" +
                "4. Device Information: We will store your device id, IP addresses, etc. We will also record the amount of time the mobile is turned on and is in use by you.\n" +
                "We will use this information for:\n" +
                "As reasonably necessary and proportionate to fulfill the purposes for which the information is provided to us.\n" +
                "Debugging our application to identify and repair errors.\n" +
                "Respond to your questions or problems you are facing.\n" +
                "The process to collect payments for our services\n" +
                "For legal purposes, we might disclose relevant information as may be necessary or required for legal, compliance, or regulatory purposes\n" +
                "1.respond to duly authorized information request from govt or police officials\n" +
                "2.compily with any rule law, or regulation given by the court\n" +
                "3.investigate and help prevent security threats and frauds\n" +
                "4. Protect your information from third-party applications and not allowing them to access your personal information.\n" +
                "With your consent, we can provide your personal information to the third-party application as well.\n" +
                "We have adopted appropriate security for protecting users’ personal information.\n" +
                "Technical and administrative measures that are designed to prevent unauthorized access or\n" +
                "Disclosure, maintain data accuracy, and ensure the appropriate use of personal information. we cannot, however, ensure or warrant the security of information.No security measures are infallible.\n" +
                "\n" +
                "Unencrypted email is not a secure method of transmission as information in such emails may be accessed and viewed by others. For this reason, we prefer that you not communicate confidential or sensitive information to us via regular unencrypted email. We will honor patient requests for communication through unencrypted email\n" +
                "\n" +
                "Time to Time we change our privacy notice. if we make changes we will revise the “last updated” date at the bottom of this notice. We encourage you to review this notice periodically\n" +
                " To be sure you are aware of those changes. Changes will become effective as of the “Last Updated” date.\n" +
                "\n" +
                "We may terminate your access to the application without a cause or notice which may result in the forfeiture and destruction of all information associated with your account. Nothing should be done via your account which is illegal or is against our security or privacy terms or it will lead to termination of the account.\n" +
                "\n" +
                "Notification provision-\n" +
                "We might change our terms and condition from time to time as it sees fit and your continued use of the site will signify your acceptance of any adjustment of these terms. If there are any changes in our privacy policy we will announce that these changes on how we use our application customers personally identifiable information notification by email will be made to those affected by the change. Any changes will be posted 30 days prior to these changes taking place.\n" +
                "\n" +
                "Android Policy-\n" +
                "We may need to adhere to a certain android policy but ads are blocked on the android and ios phoned but to show a popup we need to take permission from the user so that we can show pop-ups and train their eyes.\n" +
                "\n" +
                "Accuracy of information:- This application and its components are offered for informational purposes only and will not be liable or responsible for the accuracy of the information available via the application, and shall not be responsible for any error in the information.\n" +
                "\n" +
                "Advertisement policy:- This application and its owners show the advertisement which we believe is true and is only related to eyes and how to take care of them. But if somehow other advertisements start to come on the application you may contact us by email to remove such types of advertisements. We do not get any money by showing advertisements and are only shown for the benefit of the users. The users may or may not follow the advice given on the advertisements.\n");
        dialog.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                open();
            }
        })
                .setNegativeButton("Decline", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Action for "Cancel".
                        System.exit(0);
                    }
                });

        final AlertDialog alert = dialog.create();
        alert.show();

    }
    void open()
    {
        Intent intents=new Intent(this,Homepage.class);
        startActivity(intents);
    }
}