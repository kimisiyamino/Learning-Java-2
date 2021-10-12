public class Main {

        public static void main(String[] args) throws Exception {
        }

        interface Selectable {
            void onSelect();
        }

        interface Updatable {
            void refresh();
        }

        interface Screen extends Selectable, Updatable{

        }

}
