import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        BinaryTree tree = new BinaryTree();
        int parent[] = new int[]{-1, 0, 0, 1, 1, 3, 5};
        int n = parent.length;
        Node node = tree.createTree(parent, n);
        System.out.println("Inorder traversal of constructed tree ");
        tree.inorder(node);
        tree.newLine();
        System.out.println("--------------------------------------------------------------");

        Scanner sc = new Scanner(new FileReader("src\\islands.csv"));
        String line = "";
        String[] data = new String[]{};

        double lat = 0;
        double lon = 0;

        LatLon latLon = new LatLon(lat, lon);
        HashMap<String, LatLon> map = new HashMap<>();

        while (sc.hasNextLine()) {
            line = sc.nextLine();
            data = line.split(",");

            lat = Double.parseDouble(data[1]);
            lon = Double.parseDouble(data[2]);

            latLon = new LatLon(lat, lon);

            latLon.setLongitude(lon);
            latLon.setLatitude(lat);

            for (int i = 0; i < data.length; i += 3) {
                map.put(data[i], latLon);
            }
        }

        System.out.println(map);

        HashMap<Vertex, HashMap<Vertex, Double>> graph = new HashMap<>();

        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.size(); j++) {
                Vertex[] vertices = new Vertex[]{new Vertex("\"" + i + "\""), new Vertex("\"" + j + "\"")};
            }
        }

        System.out.println("Extra Credit: ");
        int list[] = new int[]{0, 2, 1, 4, 5, 6,3};
        int size = list.length;
        Node point = tree.createTree(list, size);
        System.out.println("Inorder traversal of constructed tree ");
        tree.inorder(point);
        tree.newLine();
    }

    public static double getDirectDistance(double lat1, double lon1, double lat2, double lon2) {
        double psi1 = lat1 * Math.PI/180;
        double psi2 = lat2 * Math.PI/180;
        double deltaPsi = psi2 - psi1;
        double deltaLambda = (lon2-lon1) * Math.PI/180;
        double a = Math.sin(deltaPsi/2) * Math.sin(deltaPsi/2) +
                Math.cos(psi1) * Math.cos(psi2) *
                        Math.sin(deltaLambda/2) * Math.sin(deltaLambda/2);
        return  2 * 6371e3 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
    }
}
