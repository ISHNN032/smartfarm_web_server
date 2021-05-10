module.exports = {
    devServer: {
        proxy: {
            '/v': {
                target: 'http://localhost:9000',
                ws: true,
                changeOrigin: true
            },
        }
    }
}