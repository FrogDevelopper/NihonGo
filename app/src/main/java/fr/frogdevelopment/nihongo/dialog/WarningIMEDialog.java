package fr.frogdevelopment.nihongo.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import fr.frogdevelopment.nihongo.R;
import fr.frogdevelopment.nihongo.preferences.Preferences;
import fr.frogdevelopment.nihongo.preferences.PreferencesHelper;

public class WarningIMEDialog extends DialogFragment {

    public static void show(FragmentManager manager) {
        new WarningIMEDialog().show(manager, "warningIMEDialog");
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(R.drawable.ic_warning);
        builder.setTitle(R.string.warning_ime_title);
        final View dialogView = requireActivity().getLayoutInflater().inflate(R.layout.dialog_warning_ime, null);
        builder.setView(dialogView);

        // Set the action buttons
        builder.setPositiveButton(android.R.string.ok, (dialog, id) -> {
            final CheckBox remember = dialogView.findViewById(R.id.warningCB);

            PreferencesHelper.getInstance(requireActivity()).saveBoolean(Preferences.REMEMBER_WARNING_IME, remember.isChecked());

            requireDialog().dismiss();
        });

        return builder.create();
    }
}
