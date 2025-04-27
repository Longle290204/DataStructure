import java.util.HashMap;

public class FirstDuplicate2 {
    public static void main(String[] args) {
        // Khởi tạo HashMap
        HashMap<String, Integer> studentScores = new HashMap<>();

        // Thêm dữ liệu vào HashMap
        studentScores.put("Alice", 85);
        studentScores.put("Bob", 92);
        studentScores.put("Charlie", 78);

        // Lấy dữ liệu từ HashMap
        System.out.println("Điểm của Bob: " + studentScores.get("Bob")); // Output: 92

        // Kiểm tra key có tồn tại hay không
        System.out.println("Có Alice không? " + studentScores.containsKey("Alice")); // Output: true

        // Duyệt qua các phần tử trong HashMap
        for (String key : studentScores.keySet()) {
            System.out.println(key + " có điểm: " + studentScores.get(key));
        }
    }
}
