package pro.sketchware.lib.highlighter;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class SyntaxScheme {

    // Define color constants for both light and dark mode
    public static final String LIGHT_COMMENTS_COLOR = "#880000";   // Light mode comment color
    public static final String DARK_COMMENTS_COLOR = "#FFAAAA";     // Dark mode comment color
    public static final String LIGHT_NOT_WORD_COLOR = "#656600";    // Light mode non-word color
    public static final String DARK_NOT_WORD_COLOR = "#A1A100";     // Dark mode non-word color
    public static final String LIGHT_NUMBERS_COLOR = "#006766";     // Light mode numbers color
    public static final String DARK_NUMBERS_COLOR = "#66B2B2";      // Dark mode numbers color
    public static final String LIGHT_PRIMARY_COLOR = "#000000";     // Light mode primary color
    public static final String DARK_PRIMARY_COLOR = "#FFFFFF";      // Dark mode primary color
    public static final String LIGHT_QUOTES_COLOR = "#008800";      // Light mode quotes color
    public static final String DARK_QUOTES_COLOR = "#00FF00";       // Dark mode quotes color
    public static final String LIGHT_SECONDARY_COLOR = "#010088";   // Light mode secondary color
    public static final String DARK_SECONDARY_COLOR = "#6699FF";    // Dark mode secondary color
    public static final String LIGHT_VARIABLE_COLOR = "#660066";    // Light mode variable color
    public static final String DARK_VARIABLE_COLOR = "#FF66FF";     // Dark mode variable color

    private static final String[] mJavaPattern = new String[12];
    private static final String[] mXmlPattern = new String[4];

    public int color;
    public Pattern pattern;

    public SyntaxScheme(Pattern pattern, int color) {
        this.pattern = pattern;
        this.color = color;
        initializeJavaPattern();
        initializeXmlPattern();
    }

    // JAVA Syntax Scheme (light and dark mode support)
    public static ArrayList<SyntaxScheme> JAVA(boolean isDarkMode) {
        ArrayList<SyntaxScheme> arrayList = new ArrayList<>();
        arrayList.add(new SyntaxScheme(Pattern.compile(mJavaPattern[0] + mJavaPattern[1]), Color.parseColor(isDarkMode ? DARK_PRIMARY_COLOR : LIGHT_PRIMARY_COLOR)));
        arrayList.add(new SyntaxScheme(Pattern.compile(mJavaPattern[2] + mJavaPattern[3] + mJavaPattern[4]), Color.parseColor(isDarkMode ? DARK_SECONDARY_COLOR : LIGHT_SECONDARY_COLOR)));
        arrayList.add(new SyntaxScheme(Pattern.compile(mJavaPattern[5]), Color.parseColor(isDarkMode ? DARK_NUMBERS_COLOR : LIGHT_NUMBERS_COLOR)));
        arrayList.add(new SyntaxScheme(Pattern.compile(mJavaPattern[11]), Color.parseColor(isDarkMode ? DARK_NOT_WORD_COLOR : LIGHT_NOT_WORD_COLOR)));
        arrayList.add(new SyntaxScheme(Pattern.compile(mJavaPattern[6]), Color.parseColor(isDarkMode ? DARK_PRIMARY_COLOR : LIGHT_PRIMARY_COLOR)));
        arrayList.add(new SyntaxScheme(Pattern.compile(mJavaPattern[10]), Color.parseColor(isDarkMode ? DARK_VARIABLE_COLOR : LIGHT_VARIABLE_COLOR)));
        arrayList.add(new SyntaxScheme(Pattern.compile(mJavaPattern[7]), Color.parseColor(isDarkMode ? DARK_NUMBERS_COLOR : LIGHT_NUMBERS_COLOR)));
        arrayList.add(new SyntaxScheme(Pattern.compile(mJavaPattern[8]), Color.parseColor(isDarkMode ? DARK_QUOTES_COLOR : LIGHT_QUOTES_COLOR)));
        arrayList.add(new SyntaxScheme(Pattern.compile(mJavaPattern[9]), Color.parseColor(isDarkMode ? DARK_COMMENTS_COLOR : LIGHT_COMMENTS_COLOR)));
        return arrayList;
    }

    // XML Syntax Scheme (light and dark mode support)
    public static ArrayList<SyntaxScheme> XML(boolean isDarkMode) {
        ArrayList<SyntaxScheme> arrayList = new ArrayList<>();
        arrayList.add(new SyntaxScheme(Pattern.compile(mJavaPattern[0] + mJavaPattern[1]), Color.parseColor(isDarkMode ? DARK_PRIMARY_COLOR : LIGHT_PRIMARY_COLOR)));
        arrayList.add(new SyntaxScheme(Pattern.compile(mXmlPattern[2]), Color.parseColor(isDarkMode ? DARK_SECONDARY_COLOR : LIGHT_SECONDARY_COLOR)));
        arrayList.add(new SyntaxScheme(Pattern.compile(mXmlPattern[0]), Color.parseColor(isDarkMode ? DARK_VARIABLE_COLOR : LIGHT_VARIABLE_COLOR)));
        arrayList.add(new SyntaxScheme(Pattern.compile(mJavaPattern[11]), Color.parseColor(isDarkMode ? DARK_NOT_WORD_COLOR : LIGHT_NOT_WORD_COLOR)));
        arrayList.add(new SyntaxScheme(Pattern.compile(mXmlPattern[3]), Color.parseColor(isDarkMode ? DARK_SECONDARY_COLOR : LIGHT_SECONDARY_COLOR)));
        arrayList.add(new SyntaxScheme(Pattern.compile(mXmlPattern[1]), Color.parseColor(isDarkMode ? DARK_COMMENTS_COLOR : LIGHT_COMMENTS_COLOR)));
        arrayList.add(new SyntaxScheme(Pattern.compile(mJavaPattern[8]), Color.parseColor(isDarkMode ? DARK_QUOTES_COLOR : LIGHT_QUOTES_COLOR)));
        return arrayList;
    }

    
        private void initializeJavaPattern() {
        mJavaPattern[0] = "\\b(out|print|println|valueOf|toString|concat|equals|for|while|switch|getText\\b";
        mJavaPattern[1] = "|println|printf|print|out|parseInt|round|sqrt|charAt|compareTo|compareToIgnoreCase|concat|contains|contentEquals|equals|length|toLowerCase|trim|toUpperCase|toString|valueOf|substring|startsWith|split|replace|replaceAll|lastIndexOf|size)\\b";
        mJavaPattern[2] = "\\b(public|private|protected|void|switch|case|class|import|package|extends|Activity|TextView|EditText|LinearLayout|CharSequence|String|int|onCreate|ArrayList|float|if|else|for|static|Intent|Button|SharedPreferences\\b";
        mJavaPattern[3] = "|abstract|assert|boolean|break|byte|case|catch|char|class|const|continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|implements|import|instanceof|interface|long|native|new|package|private|protected|";
        mJavaPattern[4] = "public|return|short|static|strictfp|super|switch|synchronized|this|throw|throws|transient|try|void|volatile|while|true|false|null)\\b";
        mJavaPattern[5] = "\\b0x[0-9a-f]{6,8}|\\b([0-9]+)\\b";
        mJavaPattern[6] = "(\\w+)(\\()+";
        mJavaPattern[7] = "(?:@)\\w+\\b";
        mJavaPattern[8] = "\"(.*)\"|'(.*)'";
        mJavaPattern[9] = "/\\*(?:.|[\\n\\r])*?\\*/|//.*";
        mJavaPattern[10] = "\\b(?:[A-Z])[a-zA-Z0-9]+\\b";
        mJavaPattern[11] = "(?!\\s)\\W";
    }

    private void initializeXmlPattern() {
        mXmlPattern[0] = "\\w+:\\w+";
        mXmlPattern[1] = "<!--(?:.|[\\n\\r])*?-->|//\\*(?:.|[\\n\\r])*?\\*//|//.*";
        mXmlPattern[2] = "<([A-Za-z][A-Za-z0-9]*)\\b[^>]*>|</([A-Za-z][A-Za-z0-9]*)\\b[^>]*>|(.+?):(.+?);";
        mXmlPattern[3] = "[<>/]";
    }

    public SyntaxScheme getPrimarySyntax() {
        return new SyntaxScheme(Pattern.compile(mJavaPattern[6]), Color.parseColor(LIGHT_PRIMARY_COLOR));
    }
}