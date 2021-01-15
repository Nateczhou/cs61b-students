import es.datastructur.synthesizer.GuitarString;
public class GuitarHero {
    private static final double CONCERT_A = 440.0;

    private static double calculateF(int index) {
        return CONCERT_A * Math.pow(2, (index - 24) / 12.0);
    }

    public static void main(String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] strings = new GuitarString[37];
        for (int i = 0; i < strings.length; i += 1) {
            strings[i] = new GuitarString(calculateF(i));
        }

        while (true) {
            // if key detected, first plunk, then tic
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (keyboard.indexOf(key) >= 0) {
                    strings[keyboard.indexOf(key)].pluck();
                }
            }
            /* compute the superposition of samples */
            double sample = 0.0;
            for (int i = 0; i < strings.length; i+=1) {
                sample += strings[i].sample();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (int i = 0; i < strings.length; i+=1) {
                strings[i].tic();
            }
        }
    }
}
