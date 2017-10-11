/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doubleLinkedList;

/**
 *
 * @author mike
 */
////////////////////////////////////////////////////////////////
class DoublyDoubleLinkListedList
   {
   private DoubleLinkList first;               // ref to first item
   private DoubleLinkList last;                // ref to last item
// -------------------------------------------------------------
   public DoublyDoubleLinkListedList()         // constructor
      {
      first = null;                  // no items on list yet
      last = null;
      }
// -------------------------------------------------------------
   public boolean isEmpty()          // true if no DoubleLinkLists
      { return first==null; }
// -------------------------------------------------------------
   public void insertFirst(long dd)  // insert at front of list
      {
      DoubleLinkList newDoubleLinkList = new DoubleLinkList(dd);   // make new DoubleLinkList

      if( isEmpty() )                // if empty list,
         last = newDoubleLinkList;             // newDoubleLinkList <-- last
      else
         first.previous = newDoubleLinkList;   // newDoubleLinkList <-- old first
      newDoubleLinkList.next = first;          // newDoubleLinkList --> old first
      first = newDoubleLinkList;               // first --> newDoubleLinkList
      }
// -------------------------------------------------------------
   public void insertLast(long dd)   // insert at end of list
      {
      DoubleLinkList newDoubleLinkList = new DoubleLinkList(dd);   // make new DoubleLinkList
      if( isEmpty() )                // if empty list,
         first = newDoubleLinkList;            // first --> newDoubleLinkList
      else
         {
         last.next = newDoubleLinkList;        // old last --> newDoubleLinkList
         newDoubleLinkList.previous = last;    // old last <-- newDoubleLinkList
         }
      last = newDoubleLinkList;                // newDoubleLinkList <-- last
      }
// -------------------------------------------------------------
   public DoubleLinkList deleteFirst()         // delete first DoubleLinkList
      {                              // (assumes non-empty list)
      DoubleLinkList temp = first;
      if(first.next == null)         // if only one item
         last = null;                // null <-- last
      else
         first.next.previous = null; // null <-- old next
      first = first.next;            // first --> old next
      return temp;
      }
// -------------------------------------------------------------
   public DoubleLinkList deleteLast()          // delete last DoubleLinkList
      {                              // (assumes non-empty list)
      DoubleLinkList temp = last;
      if(first.next == null)         // if only one item
         first = null;               // first --> null
      else
         last.previous.next = null;  // old previous --> null
      last = last.previous;          // old previous <-- last
      return temp;
      }
// -------------------------------------------------------------
                                     // insert dd just after key
   public boolean insertAfter(long key, long dd)
      {                              // (assumes non-empty list)
      DoubleLinkList current = first;          // start at beginning
      while(current.dData != key)    // until match is found,
         {
         current = current.next;     // move to next DoubleLinkList
         if(current == null)
            return false;            // didn't find it
         }
      DoubleLinkList newDoubleLinkList = new DoubleLinkList(dd);   // make new DoubleLinkList

      if(current==last)              // if last DoubleLinkList,
         {
         newDoubleLinkList.next = null;        // newDoubleLinkList --> null
         last = newDoubleLinkList;             // newDoubleLinkList <-- last
         }
      else                           // not last DoubleLinkList,
         {
         newDoubleLinkList.next = current.next; // newDoubleLinkList --> old next
                                      // newDoubleLinkList <-- old next
         current.next.previous = newDoubleLinkList;
         }
      newDoubleLinkList.previous = current;    // old current <-- newDoubleLinkList
      current.next = newDoubleLinkList;        // old current --> newDoubleLinkList
      return true;                   // found it, did insertion
      }
// -------------------------------------------------------------
   public DoubleLinkList deleteKey(long key)   // delete item w/ given key
      {                              // (assumes non-empty list)
      DoubleLinkList current = first;          // start at beginning
      while(current.dData != key)    // until match is found,
         {
         current = current.next;     // move to next DoubleLinkList
         if(current == null)
            return null;             // didn't find it
         }
      if(current==first)             // found it; first item?
         first = current.next;       // first --> old next
      else                           // not first
                                     // old previous --> old next
         current.previous.next = current.next;

      if(current==last)              // last item?
         last = current.previous;    // old previous <-- last
      else                           // not last
                                     // old previous <-- old next
         current.next.previous = current.previous;
      return current;                // return value
      }
// -------------------------------------------------------------
   public void displayForward()
      {
      System.out.print("List (first-->last): ");
      DoubleLinkList current = first;          // start at beginning
      while(current != null)         // until end of list,
         {
         current.displayDoubleLinkList();      // display data
         current = current.next;     // move to next DoubleLinkList
         }
      System.out.println("");
      }
// -------------------------------------------------------------
   public void displayBackward()
      {
      System.out.print("List (last-->first): ");
      DoubleLinkList current = last;           // start at end
      while(current != null)         // until start of list,
         {
         current.displayDoubleLinkList();      // display data
         current = current.previous; // move to previous DoubleLinkList
         }
      System.out.println("");
      }
// -------------------------------------------------------------
   }  // end class DoublyDoubleLinkListedList
////////////////////////////////////////////////////////////////
