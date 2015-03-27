package com.wt.dialogfragment.sample1;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by Kenumir on 2015-03-27.
 */
public class SampleDialog extends DialogFragment {

	public static interface OnSampleDialogCallback {
		public void onSampleDialogOkClick(DialogInterface dialog);
	}

	private OnSampleDialogCallback mOnSampleDialogCallback;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
		adb.setTitle("Sample dialog");
		adb.setMessage("Message");
		adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				if (mOnSampleDialogCallback != null)
					mOnSampleDialogCallback.onSampleDialogOkClick(dialog);
			}
		});
		return adb.create();
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mOnSampleDialogCallback = (OnSampleDialogCallback) activity;
		} catch (ClassCastException e) {}
	}
}
