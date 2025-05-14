import java.util.LinkedList;

public class Woerterbuch<K, V> {
    private static class Eintrag<K, V> {
        K key;
        V value;
        Eintrag(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Eintrag<K, V>>[] tabelle;
    private int groesse;

    public Woerterbuch (int kapazität){
        groesse = kapazität;
        tabelle = new LinkedList[groesse];
        for(int i = 0; i < groesse; i++){
            tabelle[i] = new LinkedList<>();
        }
    }

    private int hash(K key){
        return Math.abs(key.hashCode() % groesse);
    }

    public void put(K key, V value) {
        int index = hash(key);
        for (Eintrag<K,V> eintrag : tabelle[index]) {
            if (eintrag.key.equals(key)) {
                eintrag.value = value;
                return;
            }
        }
        tabelle[index].add(new Eintrag<>(key, value));
    }
    public V get(K key) {
        int index = hash(key);
        for (Eintrag<K,V> eintrag : tabelle[index]) {
            if (eintrag.key.equals(key)) {
                return eintrag.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        tabelle[index].removeIf(entry -> entry.key.equals(key));
    }
}
