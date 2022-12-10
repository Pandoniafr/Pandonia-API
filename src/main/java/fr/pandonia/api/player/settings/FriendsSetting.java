package fr.pandonia.api.player.settings;

public enum FriendsSetting {
    ALL("on", "Tout le monde"),
    FRIENDS("friends", "Uniquement mes amis"),
    OFF("off", "Personne");

    String label;
    String text;

    FriendsSetting(String label, String text) {
        this.label = label;
        this.text = text;
    }

    public String getLabel() {
        return label;
    }

    public String getText() {
        return text;
    }

    public static FriendsSetting fromString(String s){
        for (FriendsSetting value : FriendsSetting.values()) {
            if(value.getLabel().equalsIgnoreCase(s)){
                return value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return label;
    }

    public FriendsSetting next(){
        int i = this.ordinal();
        i++;
        for (FriendsSetting value : FriendsSetting.values()) {
            if(value.ordinal() == i){
                return value;
            }
        }
        return FriendsSetting.values()[0];
    }
}
