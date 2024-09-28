
// Simple MongoQuery

db.users.countDocuments();

db.users.countDocuments({name : 'aditya'})



// Sorting

db.users.find().sort({name: 1}) // ascending order

db.users.find().sort({name: -1}) // descending order

// pagination

db.users.find().skip(5).limit(10) // skips first 5 documents and retrieves next 10

// Aggregation Pipeline

db.users.aggregate([
  { $match: { age: { $gte: 25, $lte: 35 } } },
  { $group: { _id: null, averageAge: { $avg: "$age" } } }
])

// Aggregation all functions

db.users.aggregate([
  { $match: { age: { $gte: 25, $lte: 35 } } },
  { $group: { _id: null, averageAge: { $avg: "$age" }, totalUsers: { $sum: 1 } } },
  { $project: { averageAge: { $round: ["$averageAge", 2] } } }
])

// unwind list of arrays

db.users.aggregate([
  { $unwind: "$friends" },
  { $group: { _id: { name: "$name", friend: "$friends.name" }, count: { $sum: 1 } } },
  { $sort: { _id: 1 } }
])

// other things which are remaining


// Indexes

db.users.createIndex({ name: 1 }) // index on name field

db.users.createIndex({ age: -1 }) // index on age field in descending order

db.users.createIndex({ age: 1, name: 1 }) // compound index on age and name fields

// update documents

db.users.updateMany()

