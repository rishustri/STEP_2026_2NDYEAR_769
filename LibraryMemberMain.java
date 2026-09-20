class LibraryMemberMain {

    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;

    // Public no-argument constructor
    public LibraryMemberMain() {
    }

    // Write-once property
    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {

        if (membershipId == null) {
            membershipId = id;
        }
    }

    // Normal JavaBean property
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Boolean JavaBean property
    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premium) {
        this.premiumMember = premium;
    }

    // Write-only property
    public void setSecurityAnswer(String answer) {

        if (answer != null) {
            securityAnswer = Integer.toHexString(answer.hashCode());
        }
    }

    // NO getter for securityAnswer
}