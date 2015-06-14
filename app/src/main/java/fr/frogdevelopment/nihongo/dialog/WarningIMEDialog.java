package fr.frogdevelopment.nihongo.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import fr.frogdevelopment.nihongo.Preferences;
import fr.frogdevelopment.nihongo.R;

public class WarningIMEDialog extends DialogFragment {

    public static WarningIMEDialog newInstance() {
        WarningIMEDialog dialog = new WarningIMEDialog();

        return dialog;
    }

    // new WarningIMEDialog().show(getFragmentManager(), "warningIME");

    @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

        final View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_warning_ime, null);

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(android.R.drawable.stat_sys_warning);
        builder.setTitle(R.string.warning_ime_title);
        builder.setView(dialogView);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                // Gestion plus bas
            }
        });

        final CheckBox remember = (CheckBox) dialogView.findViewById(R.id.warningCB);

        Dialog dialog = builder.create();

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {

            @Override
            public void onShow(DialogInterface dialog) {
                Button btnOK = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                btnOK.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        SharedPreferences settings = getActivity().getSharedPreferences(Preferences.PREFS_NAME.value, 0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putBoolean(Preferences.REMEMBER_WARNING_IME.value, remember.isChecked());
                        // Commit the edits!
                        editor.apply();

                        getDialog().dismiss();
                    }
                });
            }
        });

        return dialog;
    }
}
