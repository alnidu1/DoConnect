const express = require('express');
const app = express();
const http = require('http').createServer(app);
const io = require('socket.io')(http);

// Define a Check model
const checks = [];

// Handle WebSocket connections
io.on('connection', (socket) => {
  console.log('A user connected');

  // Send the current checks to the newly connected client
  socket.emit('checks', checks);

  // Handle new check submissions
  socket.on('new-check', (check) => {
    console.log('New check:', check);

    // Add the new check to the list
    checks.push(check);

    // Broadcast the new check to all clients
    io.emit('new-check', check);
  });

  // Handle disconnections
  socket.on('disconnect', () => {
    console.log('A user disconnected');
  });
});

// Start the server
const port = 3000;
http.listen(port, () => {
  console.log(`Server started on port ${port}`);
});