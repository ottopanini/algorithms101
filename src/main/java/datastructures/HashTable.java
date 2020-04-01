package datastructures;

public class HashTable {

    private int INITIAL_SIZE = 16;
    private HashEntry[] data; // LinkedList

    class HashEntry {
        String key;
        String value;
        HashEntry next;

        HashEntry(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    HashTable() {
        data = new HashEntry[INITIAL_SIZE];
    }

    public void put(String key, String value) {
        int index = getIndex(key);

        HashEntry entry = new HashEntry(key, value);

        if (data[index] == null) {
            data[index] = entry;
        }
        else {
            HashEntry found = data[index];
            entry.next = found;
            data[index] = entry;
        }
    }

    public String get(String key) {
        int index = getIndex(key);
        HashEntry entries = data[index];
        if (entries != null) {
            while (entries.next != null && !key.equals(entries.key)) {
                entries = entries.next;
            }
            return entries.value;
        }
        return null;
    }

    private int getIndex(String key) {
        int hashCode = key.hashCode();
        //& 0x7fffffff abs of hashcode
        return (hashCode & 0x7fffffff)  % INITIAL_SIZE;
    }

    @Override
    public String toString() {
        int bucket = 0;
        StringBuilder hashTableStr = new StringBuilder();
        for (HashEntry entry : data) {
            if(entry == null) {
                continue;
            }
            hashTableStr.append("\n bucket[")
                    .append(bucket)
                    .append("] = ")
                    .append(entry.toString());
            bucket++;
            HashEntry temp = entry.next;
            while(temp != null) {
                hashTableStr.append(" -> ");
                hashTableStr.append(temp.toString());
                temp = temp.next;
            }
        }
        return hashTableStr.toString();
    }
}