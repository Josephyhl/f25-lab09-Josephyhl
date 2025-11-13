/**
 * Improves performance by batching addPill operations.
 */
public class BatchAddingDecorator extends PillCounterDecorator {
  private int pendingPills;

  /**
   * Constructor that takes a PillCounter to decorate.
   *
   * @param delegate the PillCounter to wrap
   */
  public BatchAddingDecorator(PillCounter delegate) {
    super(delegate);
    this.pendingPills = 0;
  }

  @Override
  public void addPill(int count) {
    pendingPills += count;
  }

  @Override
  public int getPillCount() {
    if (pendingPills > 0) {
      delegate.addPill(pendingPills);
      pendingPills = 0;
    }
    return delegate.getPillCount();
  }

  @Override
  public void reset() {
    if (pendingPills > 0) {
      delegate.addPill(pendingPills);
      pendingPills = 0;
    }
    delegate.reset();
  }
}