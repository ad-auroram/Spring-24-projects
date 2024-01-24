
function filter(data, predicate){
    //take an array of data and return a new array with entries based on a predicate

    //create new array
    //for each value in data, if it meets predicate condition, append to array
    //return array
}

function findLast(data, predicate){
    //find the last value in an array that meets the predicate's condition

    //starting at the last value of the array and going back
    //if a value meets the condition of the predicate, return value
}

function map(data, callback){
    //create a new array based on input array where each value has been passed through the callback function

    //create a new array
    //for each value in data, pass through the callback, assign to temp variable
    //append temp to new array
    //return new array
}

function pairIf(data1, data2, predicate){
    //create a new array based on input arrays, values are paired based on the condition set by the predicate (returns true or false)

    //new array
    //for each value of the arrays
    //if predicate returns true, append {data1[i], data2[i]}
    //return array
}

function reduce(data1, reducer, initialValue){
    //takes a dataset and reduces it based on the predicate
    //example given returned two arrays, sorted numbers into evens and odds
    //
}