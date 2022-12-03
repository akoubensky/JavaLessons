public class TestObject {
    private int number;
    private String name;
    private double mesure;

    private TestObject(int number, String name, double mesure) {
        this.number = number;
        this.name = name;
        this.mesure = mesure;
    }

    public static TestBuilder builder() {
        return new TestBuilder();
    }

    private static class TestBuilder {
        private int number;
        private String name;
        private double mesure;

        public TestBuilder number(int number) {
            this.number = number;
            return this;
        }

        public TestBuilder name(String name) {
            this.name = name;
            return this;
        }

        public TestBuilder mesure(double mesure) {
            this.mesure = mesure;
            return this;
        }

        public TestObject build() {
            return new TestObject(number, name, mesure);
        }
    }

    public static void main(String[] args) {
        TestObject obj = TestObject.builder()
                .mesure(12.5)
                .name("Vasja")
                .number(25)
                .build();
    }
}
