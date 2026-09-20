class LibraryMember {
    private String membershipPin;
    String branchCode;              // default
    protected double finesOwed;
    public String displayName;
}

class AccessChecker {

    static String classifyAccess(String fieldModifier, String accessorContext) {

        if (fieldModifier.equals("private")) {
            return accessorContext.equals("SAME_CLASS")
                    ? "ALLOWED" : "DENIED";
        }

        if (fieldModifier.equals("default")) {
            return accessorContext.equals("SAME_CLASS") ||
                   accessorContext.equals("SAME_PACKAGE")
                    ? "ALLOWED" : "DENIED";
        }

        if (fieldModifier.equals("protected")) {
            return accessorContext.equals("SAME_CLASS") ||
                   accessorContext.equals("SAME_PACKAGE") ||
                   accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")
                    ? "ALLOWED" : "DENIED";
        }

        if (fieldModifier.equals("public")) {
            return "ALLOWED";
        }

        return "DENIED";
    }

    static String summarizeByModifier(String[][] attempts) {

        String[] modifiers = {"private", "default", "protected", "public"};
        int[] allowed = new int[4];
        int[] denied = new int[4];

        for (String[] attempt : attempts) {
            String modifier = attempt[0];
            String context = attempt[1];

            String result = classifyAccess(modifier, context);

            for (int i = 0; i < modifiers.length; i++) {
                if (modifier.equals(modifiers[i])) {
                    if (result.equals("ALLOWED"))
                        allowed[i]++;
                    else
                        denied[i]++;
                }
            }
        }

        return "private: " + allowed[0] + " allowed / " + denied[0] + " denied | "
             + "default: " + allowed[1] + " allowed / " + denied[1] + " denied | "
             + "protected: " + allowed[2] + " allowed / " + denied[2] + " denied | "
             + "public: " + allowed[3] + " allowed / " + denied[3] + " denied";
    }
}