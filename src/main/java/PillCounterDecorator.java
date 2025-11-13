/**
 * A basic decorator for PillCounter that delegates all operations
 * to the wrapped PillCounter object.
 */
public class PillCounterDecorator implements PillCounter {
  protected PillCounter delegate;

  /**
   * Constructor that takes a PillCounter to decorate.
   *
   * @param delegate the PillCounter to wrap
   */
  public PillCounterDecorator(PillCounter delegate) {
    this.delegate = delegate;
  }

  @Override
  public void addPill(int count) {
    delegate.addPill(count);
  }

  @Override
  public void removePill() {
    delegate.removePill();
  }

  @Override
  public void reset() {
    delegate.reset();
  }

  @Override
  public int getPillCount() {
    return delegate.getPillCount();
  }
}