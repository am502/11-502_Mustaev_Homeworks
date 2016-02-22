package ru.itis.inform;

import static org.junit.Assert.*;

public class LinkedListIteratorImplTest {
    private LinkedList<Integer> list;
    private Iterator<Integer> iter;

    @org.junit.Before
    public void setUp() {
        this.list = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        this.iterator = list.iterator();
    }

    @org.junit.Test
    public void testHasNext() throws Exception {
        assertTrue(iterator.hasNext());
        for (int i = 0; i < 5; i++) {
            iterator.next();
        }
        assertFalse(iterator.hasNext());
    }

    @org.junit.Test
    public void testPrevious() throws Exception {
        iterator.next();
        iterator.next();
        assertEquals(iterator.previous(), (Integer) 1);
        assertEquals(iterator.previous(), (Integer) 2);
    }

    @org.junit.Test
    public void testInsert() throws Exception {
        iterator.next();
        iterator.insert(16);
        assertEquals(iterator.next(), (Integer) );
        assertEquals(iterator.previous(), (Integer) 4);
        assertEquals(iterator.peekPrevious(), (Integer) 16);
        iterator.previous();
        assertEquals(iterator.peekPrevious(), (Integer) 8);
    }
}