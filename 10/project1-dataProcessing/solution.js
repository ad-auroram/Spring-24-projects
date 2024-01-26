console.log(transactions)

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
        if (predicate(data[i])){
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
    for (val1 of data1){
        for(val2 of data2){
            if (predicate(val1, val2)){
                newArray.push([val2, val1]);
            }
        }
    }
    return newArray;
}

function reduce(data, reducer, initialValue){
    //takes a dataset and reduces it based on the predicate
    //example given returned two arrays, sorted numbers into evens and odds
    //
    let acc = initialValue;
    for (val of data){
        reducer(val, acc);
    }
    return acc;
}

let validJam = ["FIG_JAM", "FIG_JELLY", "SPICY_FIG_JAM", "ORANGE_FIG_JELLY"];
const numInvalid = filter(transactions, value => value.amount===null||value.amount===undefined||value.amount===0||validJam.includes(value.product)===false).length;
const duplicates = pairIf(customers, customers, (val1, val2) => val1.emailAddress===val2.emailAddress && val1.id !== val2.id).length/2;
const overAmount = findLast(transactions, data => data.amount > 200).amount;
//debugger;
const sortedTransaction = reduce(transactions, (val, acc) => {
    if (val.amount!==null&&val.amount!==undefined&&val.amount!==0&&validJam.includes(val.product)===true){
        if (val.amount<=25){
            acc.small.push(val);
        }else if (25<=val.amount && val.amount<75){
            acc.medium.push(val);
        }else if (75<=val.amount){
            acc.large.push(val);
        }
    }
}, {small: [], medium: [], large: []});
const small = sortedTransaction.small.length;
const medium = sortedTransaction.medium.length;
const large = sortedTransaction.large.length;

console.log(`Number of invalid transactions: ${numInvalid}`);
console.log(`Number of duplicate customers: ${duplicates}`);
console.log(`Most recnet transaction over $200: $${overAmount}`);
console.log(`Number of small transactions: ${small}`);
console.log(`Number of medium transactions: ${medium}`);
console.log(`Number of large transactions: ${large}`);
console.log("Customers with transactions over $200: ${}");
console.log("Names of customers with transactions over $200: ${}");