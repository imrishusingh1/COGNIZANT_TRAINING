import React, { Component } from 'react';

class ErrorBoundary extends Component {
  constructor(props) {
    super(props);
    this.state = { hasError: false, error: null };
  }

  componentDidCatch(error, errorInfo) {
    console.log('Error caught:', error, errorInfo);
    this.setState({ hasError: true, error: error.message });
  }

  render() {
    if (this.state.hasError) {
      return <div style={{ color: 'red', padding: '10px' }}>
        <h3>Something went wrong!</h3>
        <p>{this.state.error}</p>
      </div>;
    }
    return this.props.children;
  }
}

class BlogPost extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      loading: true
    };
  }

  componentDidMount() {
    
    console.log('BlogPost componentDidMount: fetching posts...');
    setTimeout(() => {
      this.setState({
        posts: [
          { id: 1, title: 'Introduction to React', author: 'Alice', date: '2024-01-15' },
          { id: 2, title: 'Understanding Lifecycle Methods', author: 'Bob', date: '2024-01-20' },
          { id: 3, title: 'Component State and Props', author: 'Carol', date: '2024-01-25' },
        ],
        loading: false
      });
      console.log('BlogPost: posts loaded!');
    }, 1000);
  }

  componentWillUnmount() {
    console.log('BlogPost componentWillUnmount: cleanup');
  }

  render() {
    const { loading, posts } = this.state;

    if (loading) {
      return <p>Loading blog posts...</p>;
    }

    return (
      <div>
        {posts.map(post => (
          <div key={post.id} style={{
            border: '1px solid #ddd',
            padding: '15px',
            margin: '10px',
            borderRadius: '5px'
          }}>
            <h3>{post.title}</h3>
            <p>By {post.author} | {post.date}</p>
          </div>
        ))}
      </div>
    );
  }
}

function App() {
  return (
    <div style={{ fontFamily: 'Arial, sans-serif', padding: '20px' }}>
      <h1>Blog App - ReactJS HOL 4</h1>
      <h2>Component Lifecycle Demo</h2>
      <p>Check the browser console to see lifecycle method calls.</p>
      <ErrorBoundary>
        <BlogPost />
      </ErrorBoundary>
    </div>
  );
}

export default App;
