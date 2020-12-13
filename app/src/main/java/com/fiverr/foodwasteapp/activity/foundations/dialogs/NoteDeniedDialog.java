package com.fiverr.foodwasteapp.activity.foundations.dialogs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.fiverr.foodwasteapp.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

/**
 * Class NoteDeniedDialog that create a dialog fragment
 * with an InputEditText to enter a message
 */
public class NoteDeniedDialog {
    // Create an instance of MaterialAlertDialogBuilder to create the dialog
    private final MaterialAlertDialogBuilder materialAlertDialogBuilder;
    // Create a View to get the XML layout
    private final View mainView;
    // Instance the input of XML layout dialog
    private final TextInputEditText mInputMessage;
    // Instance the activity that called to get Resources
    private final Context context;
    // Instance an Interface to detect the clicks on the Positive Button of Dialog
    // more info: Review IClickListener interface, it's here same
    private final IClickListener listener;

    /**
     * Constructor NoteDialog
     * @param context is the activity that called
     * @param materialAlertDialogBuilder is the instance of MaterialAlertDialogBuilder to create the dialog
     * @param listener is an Interface to detect the clicks on the Positive Button of Dialog
     */
    @SuppressLint("InflateParams")
    public NoteDeniedDialog(Context context, MaterialAlertDialogBuilder materialAlertDialogBuilder, IClickListener listener) {
        this.materialAlertDialogBuilder = materialAlertDialogBuilder;
        this.context = context;
        this.listener = listener;
        // Inflate XML layout on View to instance Class with XML file
        this.mainView = LayoutInflater.from(context).inflate(R.layout.dialog_note_denied_request, null, false);
        // Verify if the mainView is not null
        assert mainView != null;
        // Find the input View on XML Layout
        mInputMessage = mainView.findViewById(R.id.input_deny_message);
    }

    /**
     * This method creates an Custom Dialog with two Buttons (Positive Button and Negative)
     * Negative Button only close the dialog
     */
    public void show() {
        // Set View on Dialog
        materialAlertDialogBuilder.setView(mainView)
                // set Positive Button with a name and an Listener that is send for interface Listener (IClickListener)
                .setPositiveButton(context.getResources().getString(R.string.send),
                        (dialogInterface, i) -> listener.onSendMessage(Objects.requireNonNull(mInputMessage.getText()).toString()))
                // Set Negative Button with a name and only close the dialog
                .setNegativeButton(context.getResources().getString(R.string.cancel), (dialogInterface, i) -> dialogInterface.dismiss())
                // Show the dialog for user
                .show();
    }

    /**
     * IClick Listener is the interface that act how an listener
     * to send message for activity
     */
    public interface IClickListener {
        // Send message Method is the message that send for activity
        void onSendMessage(String message);
    }

}
