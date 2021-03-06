# TargetProject

## The goal of this exercise is to create a working program to search a set of documents for the given search term or phrase (single token), and return results in order of relevance. 

Relevancy is defined as number of times the exact term or phrase appears in the document. 

## Create three methods for searching the documents: 

Simple string matching

Text search using regular expressions

Preprocess the content and then search the index


Enter the search term: <user enters search term>
 
Search Method: 1) String Match 2) Regular Expression 3) Indexed
 
Search results: 
File2.txt – X matches
File1.txt - X matches
File3.txt – X matches
Elapsed time: 40 msPrompt the user to enter a search term and search method, execute the search, and return results. For instance:
 
Three files have been provided for you to read and use as sample search content.
 
## Run a performance test that does 2M searches with random search terms, and measures execution time. Which approach is fastest? Why?
 Indexed search is by far the fastest. This is because when you index it first, the search time becomes constant. But for the other two search methods you have to check each word in the file every time you seach. This leads the other searches to be O(n).
 
## Provide some thoughts on what you would do on the software or hardware side to make this program scale to handle massive content and/or very large request volume (5000 requests/second or more).
 I would index the content first and store it in a database. I would use a key-value NoSQL database so that way everything is already indexed. Since we are storing these values in the database we would be able to have constant access to the value and you would be able multithread it. This way you could handle many requests at once. I would also want to set up a load balancer that could distribute the requests across multiple servers so that way during request spikes, it wouldn't overload the server.
