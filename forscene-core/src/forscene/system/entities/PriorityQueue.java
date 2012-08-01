/**
 * 
 */
package forscene.system.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * @author blackdevil
 * 
 */

public class PriorityQueue<E> implements Queue<E> {
  private ArrayList<LinkedList<E>> queue;
  private int                      size = 0;

  /**
   * 
   */
  public PriorityQueue() {
    queue = new ArrayList<LinkedList<E>>(
        ForSceneConfigurator.EVENT_MANAGER_PRIORITY_QUEUE_SIZE);

    for (int i = 0; i < ForSceneConfigurator.EVENT_MANAGER_PRIORITY_QUEUE_SIZE; i++) {
      queue.add(i, new LinkedList<E>());
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.Collection#addAll(java.util.Collection)
   */
  public boolean addAll(Collection<? extends E> c) {
    queue.get(ForSceneConfigurator.EVENT_MANAGER_DEFAULT_EVENT_PRIORITY)
        .addAll(c);
    size = recalculateSize();
    return false;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.Collection#clear()
   */
  public void clear() {
    for (int i = 0; i < ForSceneConfigurator.EVENT_MANAGER_PRIORITY_QUEUE_SIZE; i++) {
      queue.get(i).clear();
    }
    size = 0;

  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.Collection#contains(java.lang.Object)
   */
  public boolean contains(Object o) {
    for (int i = 0; i < ForSceneConfigurator.EVENT_MANAGER_PRIORITY_QUEUE_SIZE; i++) {
      if (queue.get(i).contains(o)) {
        return true;
      }
    }
    return false;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.Collection#containsAll(java.util.Collection)
   */
  public boolean containsAll(Collection<?> c) {
    for (Object element : c) {
      Object object = element;
      if (!contains(object)) {
        return false;
      }
    }
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.Collection#isEmpty()
   */
  public boolean isEmpty() {
    size = recalculateSize();
    // PlayN.log().debug("IsEmpty size: " + size);
    if (size != 0) {
      return false;
    }
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.Collection#iterator()
   */
  public Iterator<E> iterator() {
    Iterator<E> it = new Iterator<E>();
    it.setParentCollection(this.queue);
    it.initIterator((short) 0);
    return it;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.Collection#remove(java.lang.Object)
   */
  public boolean remove(Object o) {
    for (int i = 0; i < ForSceneConfigurator.EVENT_MANAGER_PRIORITY_QUEUE_SIZE; i++) {
      if (queue.get(i).remove(o)) {
        size--;
        return true;
      }
    }
    return false;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.Collection#removeAll(java.util.Collection)
   */
  public boolean removeAll(Collection<?> c) {
    short removedEle = 0;
    for (Object element : c) {
      if (remove(element)) {
        removedEle++;
      }
    }
    size -= removedEle;
    return (removedEle != 0);
  }

  /*
   * (non-Javadoc)
   * 
   * 
   * 
   * @see java.util.Collection#retainAll(java.util.Collection)
   */

  public boolean retainAll(Collection<?> c) {
    boolean result = false;
    this.size = 0;
    for (int i = 0; i < ForSceneConfigurator.EVENT_MANAGER_PRIORITY_QUEUE_SIZE; i++) {
      result |= queue.get(i).retainAll(c);
      size += queue.get(i).size();
    }
    return result;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.Collection#size()
   */
  public int size() {
    return size;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.Collection#toArray()
   */
  public Object[] toArray() {
    size = recalculateSize();
    Object[] tmp = new Object[this.size()];
    int tmpSize = 0;
    for (int i = 0; i < ForSceneConfigurator.EVENT_MANAGER_PRIORITY_QUEUE_SIZE; i++) {
      for (int j = 0; j < queue.get(i).size(); j++) {
        E element = queue.get(i).get(j);
        tmp[tmpSize + j] = element;
      }
      tmpSize += queue.get(i).size();
    }
    return tmp;
  }

  /*
   * (non-Javadoc)
   * 
   * 
   * @see java.util.Collection#toArray(T[])
   */
  @Deprecated
  public <E> E[] toArray(E[] a) {
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.Queue#add(java.lang.Object)
   */
  public boolean add(E e) {
    if (e == null) {
      return false;
    }
    return add(e, ForSceneConfigurator.EVENT_MANAGER_DEFAULT_EVENT_PRIORITY);
  }

  public boolean add(E e, short priority) {
    if (e == null) {
      return false;
    }
    boolean res = queue.get(priority).add(e);
    // PlayN.log().debug("Pushed : " + e);
    return res;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.Queue#element()
   */

  public E element() {
    for (int i = 0; i < ForSceneConfigurator.EVENT_MANAGER_PRIORITY_QUEUE_SIZE;) {
      try {
        E tmp = queue.get(i).element();
        return tmp;
      } catch (NoSuchElementException e) {
      }
    }
    // throw new NoSuchElementException();
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.Queue#offer(java.lang.Object)
   */
  public boolean offer(E e) {
    return offer(e, ForSceneConfigurator.EVENT_MANAGER_DEFAULT_EVENT_PRIORITY);
  }

  /*
   * (non-Javadoc) priority is relative to queue
   * 
   * @see java.util.Queue#offer(java.lang.Object)
   */
  public boolean offer(E e, short priority) {
    boolean res = queue.get(priority).offer(e);
    return res;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.Queue#peek()
   */
  public E peek() {
    for (int i = 0; i < ForSceneConfigurator.EVENT_MANAGER_PRIORITY_QUEUE_SIZE; i++) {
      if (!queue.get(i).isEmpty()) {
        return queue.get(i).peek();
      }
    }
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.Queue#poll()
   */
  public E poll() {
    for (int i = 0; i < ForSceneConfigurator.EVENT_MANAGER_PRIORITY_QUEUE_SIZE; i++) {
      if (!(queue.get(i).isEmpty())) {
        E e = queue.get(i).poll();
        // PlayN.log().debug("Popped : " + e);
        return e;
      }
    }
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.util.Queue#remove()
   */
  public E remove() {
    for (int i = 0; i < ForSceneConfigurator.EVENT_MANAGER_PRIORITY_QUEUE_SIZE; i++) {
      if (!queue.get(i).isEmpty()) {
        E e = queue.get(i).remove();
        return e;
      }
    }
    return null;
  }

  private int recalculateSize() {
    this.size = 0;
    for (int i = 0; i < ForSceneConfigurator.EVENT_MANAGER_PRIORITY_QUEUE_SIZE; i++) {
      this.size += queue.get(i).size();
    }
    return this.size;
  }

  public class Iterator<E> implements java.util.Iterator<E> {
    private short                    currentIndex;
    private java.util.Iterator<E>    _iterator;
    private ArrayList<LinkedList<E>> parent;
    private boolean                  init = false;

    /**
     * 
     */
    public Iterator() {
      currentIndex = 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Iterator#hasNext()
     */
    public boolean hasNext() {
      if (_iterator.hasNext()) {
        return true;
      }

      if (currentIndex < (ForSceneConfigurator.EVENT_MANAGER_PRIORITY_QUEUE_SIZE - 1)) {
        return true;
      }
      return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Iterator#next()
     */
    public E next() {
      E element = null;
      try {
        element = _iterator.next();
      } catch (NoSuchElementException e) {
        for (; currentIndex < (ForSceneConfigurator.EVENT_MANAGER_PRIORITY_QUEUE_SIZE); currentIndex++) {
          if (!queue.get(currentIndex).isEmpty()) {
            _iterator = (java.util.Iterator<E>) queue.get(currentIndex)
                .iterator();
            return _iterator.next();
          }
        }
      }
      // throw new NoSuchElementException();
      return null;

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Iterator#remove()
     */
    public void remove() {
      _iterator.remove();
    }

    private void setParentCollection(ArrayList<LinkedList<E>> parent) {
      this.parent = parent;
    }

    private void initIterator(short index) {
      _iterator = (parent.get(currentIndex)).iterator();
    }
  }

}
