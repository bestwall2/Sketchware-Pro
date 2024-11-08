package pro.sketchware.lib.highlighter;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.widget.EditText;

import com.besome.sketch.editor.LogicEditorActivity;

import java.util.List;
import java.util.regex.Matcher;

/**
 * A Helper class used in {@link LogicEditorActivity}
 * to (currently) highlight add source directly blocks.
 */
public class SimpleHighlighter {

    private final EditText mEditor;
    private final List<SyntaxScheme> syntaxList;

    public SimpleHighlighter(EditText editor) {
        mEditor = editor;
        boolean isDarkMode = isDarkMode(mEditor.getContext()); // Auto detect dark mode
        syntaxList = SyntaxScheme.JAVA(isDarkMode); // Pass the dark mode flag here
        init();
    }

    private void init() {
        removeSpans(mEditor.getText(), ForegroundColorSpan.class);
        createHighlightSpans(syntaxList, mEditor.getText());

        mEditor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                removeSpans(s, ForegroundColorSpan.class);
                createHighlightSpans(syntaxList, s);
            }
        });
    }

    private void createHighlightSpans(List<SyntaxScheme> syntaxList, Editable editable) {
        for (SyntaxScheme scheme : syntaxList) {
            for (Matcher m = scheme.pattern.matcher(editable); m.find(); ) {
                if (scheme == scheme.getPrimarySyntax()) {
                    editable.setSpan(new ForegroundColorSpan(scheme.color), m.start(), m.end() - 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                } else {
                    editable.setSpan(new ForegroundColorSpan(scheme.color), m.start(), m.end(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            }
        }
    }

    private void removeSpans(Editable editable, Class<? extends CharacterStyle> type) {
        CharacterStyle[] spans = editable.getSpans(0, editable.length(), type);
        for (CharacterStyle span : spans) {
            editable.removeSpan(span);
        }
    }

    // Method to check if the app is in dark mode or not
    private boolean isDarkMode(Context context) {
        int nightModeFlags = context.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        return nightModeFlags == Configuration.UI_MODE_NIGHT_YES;
    }
}
