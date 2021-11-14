package hw7;

public enum Size {

    XXS(36, "Детский") {
        @Override
        public String getDescription() {
            return "детский";
        }
    },
    XS(38,"Взрослый"),
    S(40, "Взрослый"),
    M(42,"Взрослый"),
    L(44,"Взрослый");
    private int euroSize;
    private String description;

    Size(int euroSize,String description) {
        this.euroSize = euroSize;
        this.description=description;
    }
    public String getDescription() {
        return "взрослый";
    }
    @Override
    public String toString() {
        return name() + "(" + euroSize + ") " + getDescription();
    }

}
