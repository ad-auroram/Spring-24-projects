
function filter(data, predicate){
    //take an array of data and return a new array with entries based on a predicate

    //create new array
    //for each value in data, if it meets predicate condition, append to array
    //return array
    const newArray = [];
    for (const value of data){
        if (predicate(value)){
            newArray.push(value)
        }
    }
    return newArray;
}

function findLast(data, predicate){
    //find the last value in an array that meets the predicate's condition

    //starting at the last value of the array and going back
    //if a value meets the condition of the predicate, return value

    for (let i = data.length-1; i>=0; i--){
        if (predicate(date[i])){
            return data[i];
        }
    }
    console.log("No value meets the condition.")
    return null;
}

function map(data, callback){
    //create a new array based on input array where each value has been passed through the callback function

    //create a new array
    //for each value in data, pass through the callback, assign to temp variable
    //append temp to new array
    //return new array

    const newArray = [];
    for (value of data){
        let temp = callback(value);
        newArray.push(temp);
    }
    return newArray;
}

function pairIf(data1, data2, predicate){
    //create a new array based on input arrays, values are paired based on the condition set by the predicate (returns true or false)

    //new array
    //for each value of the arrays
    //if predicate returns true, append {data1[i], data2[i]}
    //return array

    const newArray = []
    for (value of data1){
        for(data of data2){
            if (predicate(value, data)){
                newArray.push([data, value]);
            }
        }
    }
    return newArray;
}

function reduce(data1, reducer, initialValue){
    //takes a dataset and reduces it based on the predicate
    //example given returned two arrays, sorted numbers into evens and odds
    //
}


console.log("Number of invalid transactions: ${}");
console.log("Number of duplicate customers: ${}");
console.log("Most recnet transaction over $200: $${}");
console.log("Number of small transactions: ${}");
console.log("Number of medium transactions: ${}");
console.log("Number of large transactions: ${}");
console.log("Customers with transactions over $200: ${}");
console.log("Names of customers with transactions over $200: ${}");