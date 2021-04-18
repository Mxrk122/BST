/**
 * @author: GeeksforGeeks
 */
class Node
    {
        int key;
        Association<String, String[]> traduccion;
        Node left, right;
 
        public Node(int item, Association<String,String[]> valor)
        {
            // La clave sera para encontrar el item
            key = item;
            left = right = null;

            traduccion = valor;
        }

        
        /** 
         * @return Association<String, String[]>
         */
        public Association<String, String[]> getTraduccion() {
            return traduccion;
        }

        
        /** 
         * @return int
         */
        public int getKey() {
            return key;
        }

        
        /** 
         * @return String
         */
        @Override
        public String toString() {
        // TODO Auto-generated method stub
        return traduccion.getKey();
        }
    }