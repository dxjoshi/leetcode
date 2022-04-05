public interface ReadWriteLock {
    ReentrantReadWriteLock.WriteLock writeLock();
    ReentrantReadWriteLock.ReadLock  readLock();
}
