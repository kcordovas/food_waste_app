package com.fiverr.foodwasteapp.activity.foundations;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;

import com.fiverr.foodwasteapp.R;
import com.fiverr.foodwasteapp.databinding.DialogFullScreenFoundationVerificationCodeBinding;

public class DialogFullScreenFoundationVerificationCode extends DialogFragment implements View.OnClickListener {
    private DialogFullScreenFoundationVerificationCodeBinding binding;
    private Bundle receivedBundle;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), R.layout.dialog_full_screen_foundation_verification_code, container, false);
        receivedBundle = getArguments();
        binding.imageIconCloseDialog.setOnClickListener(this);
        binding.buttonOkDialogFull.setOnClickListener(this);
        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        int idView = view.getId();
        if (idView == binding.buttonOkDialogFull.getId() ||
                idView == binding.imageIconCloseDialog.getId())
            dismiss();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.buttonVerificationCode.setText(receivedBundle.getString(this.getTag()));
    }
}
