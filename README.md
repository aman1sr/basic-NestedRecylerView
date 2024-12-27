# Basic Nested RecyclerView

## Overview
This Android project demonstrates simple example of Nested RecyclerView , used simple the Parent-Child Adapter Concept

![Sample GIF](https://media.tenor.com/Ev-U2h5FXWkAAAAM/android-dance.gif)

## Implementation Details

- used custom GOT json data (stored in asset folder)
- used 3 xml layout in this project :
  - Activity UI:  For ActionBar & Parent RecyclerView 
  - Parent House Layout (item_row_parent.xml ):  for Parent RecyclerView — which consists of Title & child recyclerview. 
  - Child Member Layout (item_row_child.xml): for Child RecyclerView item
- used ListAdapter class for setting ParentHouseAdapter and ChildMemberAdapter

---

### Screenshots

<div align="center">
    <img src="https://github.com/aman1sr/basicNestedRecylerView/blob/master/app/screenshot/basic_nested_revView1.png?raw=true?raw=true" alt=" Screenshot1" width="30%"  />
    <img src="https://github.com/aman1sr/basicNestedRecylerView/blob/master/app/screenshot/basic_nested_revView2.png?raw=true?raw=true" alt=" Screenshot2" width="30%"  />
    <img src="https://github.com/aman1sr/basicNestedRecylerView/blob/master/app/screenshot/basic_nested_revView3.png?raw=true?raw=true" alt=" Screenshot3" width="30%"  />
</div>

---
##  Article references:
- [Article Link: medium NestedRecView](https://medium.com/nerd-for-tech/nested-recyclerview-in-android-e5afb2b9771a)
- [Article Link: medium ListAdapter](https://medium.com/androiddevelopers/adapting-to-listadapter-341da4218f5b)
- [Article Link: listAdpater doc](https://developer.android.com/reference/androidx/recyclerview/widget/ListAdapter)
- [GOT json Data:](https://gameofthronesquotes.xyz/)







