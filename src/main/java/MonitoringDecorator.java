import java.util.ArrayList;
import java.util.List;

/**
 * A decorator that monitors the number of times addPill is called
 * between resets.
 */
public class MonitoringDecorator extends PillCounterDecorator {
  private List<Integer> addCounts;
  private int currentAddCount;

  /**
   * Constructor that takes a PillCounter to decorate.
   *
   * @param delegate the PillCounter to wrap
   */
  public MonitoringDecorator(PillCounter delegate) {
    super(delegate);
    this.addCounts = new ArrayList<>();
    this.currentAddCount = 0;
  }

  @Override
  public void addPill(int count) {
    currentAddCount++;
    delegate.addPill(count);
  }

  @Override
  public void reset() {
    addCounts.add(currentAddCount);
    currentAddCount = 0;
    delegate.reset();
  }

  /**
   * Get the list of add counts recorded between resets.
   *
   * @return list of add counts
   */
  public List<Integer> getAddCounts() {
    return new ArrayList<>(addCounts);
  }
}