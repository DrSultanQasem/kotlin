// "Create object 'NotExistent'" "false"
// ACTION: Create class 'NotExistent'
// ACTION: Create interface 'NotExistent'
// ACTION: Create type parameter 'NotExistent' in class 'TPB'
// ACTION: Create test
// ACTION: Enable a trailing comma by default in the formatter
// ERROR: Unresolved reference: NotExistent
class TPB<X : <caret>NotExistent>