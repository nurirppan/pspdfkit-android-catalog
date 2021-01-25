/*
 *   Copyright © 2016-2021 PSPDFKit GmbH. All rights reserved.
 *
 *   The PSPDFKit Sample applications are licensed with a modified BSD license.
 *   Please see License for details. This notice may not be removed from this file.
 */

package com.pspdfkit.catalog.examples.java;

import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import androidx.annotation.NonNull;

import com.pspdfkit.catalog.PSPDFExample;
import com.pspdfkit.catalog.examples.java.activities.ScreenReaderExampleActivity;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.document.providers.AssetDataProvider;
import com.pspdfkit.catalog.R;
import com.pspdfkit.ui.PdfActivityIntentBuilder;

/**
 * This example showcases how to build a screen reader. It uses Android's {@link TextToSpeech} class for text synthesis while highlighting spoken text using
 * PSPDFKit's drawable provider API.
 */
public class ScreenReaderExample extends PSPDFExample {

    public ScreenReaderExample(@NonNull Context context) {
        super(context.getString(R.string.screenReaderExampleTitle), context.getString(R.string.screenReaderExampleDescription));
    }

    @Override
    public void launchExample(@NonNull Context context, @NonNull PdfActivityConfiguration.Builder configuration) {
        // Simply loads a document from the assets. The actual screen reading is performed by the activity.
        // Launch the custom example activity using the document and configuration.
        final Intent intent = PdfActivityIntentBuilder.fromDataProvider(context, new AssetDataProvider("Guide-v6.pdf"))
            .configuration(configuration.build())
            .activityClass(ScreenReaderExampleActivity.class)
            .build();

        // Start the ScreenReaderExampleActivity for the extracted document.
        context.startActivity(intent);
    }
}
