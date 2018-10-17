public enum Image {

        // Add link to new product images here
        OLD_GRAY("productAssets/oldgray.jpg"),
        GRANITE("productAssets/granite.jpg"),
        SLATE("productAssets/slate.jpg");

        private String htmlLink;
        Image(String htmlLink) {
            setHtmlLink(htmlLink);
        }

        public String getHtmlLink() {
            return htmlLink;
        }

        private void setHtmlLink(String htmlLink) {
            this.htmlLink = htmlLink;
        }
    }

