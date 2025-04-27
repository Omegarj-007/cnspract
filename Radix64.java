public class Radix64 {
    static final String base64Chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    public static String encode(String input) {
        StringBuilder result = new StringBuilder();
        byte[] bytes = input.getBytes();
        int i = 0;
        while (i < bytes.length) {
            int b = (bytes[i++] & 0xff) << 16;
            if (i < bytes.length)
                b |= (bytes[i++] & 0xff) << 8;
            if (i < bytes.length)
                b |= (bytes[i++] & 0xff);
            for (int j = 18; j >= 0; j -= 6) {
                result.append(base64Chars.charAt((b >> j) & 0x3f));
            }
        }
        while (result.length() % 4 != 0) {
            result.append("=");
        }
        return result.toString();
    }
    public static String decode(String encoded) {
        encoded = encoded.replace("=", "");
        byte[] output = new byte[encoded.length() * 3 / 4];
        int outIndex = 0;
        int i = 0;
        while (i < encoded.length()) {
            int b = base64Chars.indexOf(encoded.charAt(i++)) << 18;
            b |= base64Chars.indexOf(encoded.charAt(i++)) << 12;
            int char3 = (i < encoded.length()) ? base64Chars.indexOf(encoded.charAt(i++)) : 0;
            b |= char3 << 6;
            int char4 = (i < encoded.length()) ? base64Chars.indexOf(encoded.charAt(i++)) : 0;
            b |= char4;
            output[outIndex++] = (byte) ((b >> 16) & 0xff);
            if (char3 != 0) output[outIndex++] = (byte) ((b >> 8) & 0xff);
            if (char4 != 0) output[outIndex++] = (byte) (b & 0xff);
        }
        return new String(output, 0, outIndex);
    }
    public static void main(String[] args) {
        String message = "HelloJava";
        String encoded = encode(message);
        System.out.println("Encoded: " + encoded);
        String decoded = decode(encoded);
        System.out.println("Decoded: " + decoded);
    }
}
