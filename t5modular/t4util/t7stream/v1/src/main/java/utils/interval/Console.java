package utils.interval;

public class Console extends utils.Console {
    
    private static Console instance;
    
    public static Console instance() {
        if (Console.instance == null) {
            Console.instance = new Console();
        }
        return Console.instance;
    }
    
    public Interval readInterval() {
		return this.readInterval("");
	}

	public Interval readInterval(String title) {
		assert title != null;

		return utils.Console.instance().read(title,
				new Interval(0, 0),
				input -> Interval.parseInterval(input) != null,
				input -> Interval.parseInterval(input));
	}


}
