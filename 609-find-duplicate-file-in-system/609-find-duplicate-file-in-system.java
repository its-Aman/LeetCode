class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> directory = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for (String path : paths) {
            String[] parsed = path.split(" ", 2);
            String dir = parsed[0];
            Content[] extracted = extractFileInfo(parsed[1]);

            for (Content c : extracted)
                directory.computeIfAbsent(c.text, k -> new ArrayList<>()).add(dir.concat("/").concat(c.filaName));
        }

        for (var key : directory.keySet()) {
            var list = directory.get(key);
            if (list.size() > 1)
                ans.add(list);
        }

        return ans;
    }

    private Content[] extractFileInfo(String paths) {
        String[] splitPath = paths.split(" ");
        Content[] contents = new Content[splitPath.length];

        for (int i = 0; i < splitPath.length; i++)
            contents[i] = extract(splitPath[i]);

        return contents;
    }

    private Content extract(String path) {
        StringBuilder sb = new StringBuilder();
        Content content = new Content();

        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '(') {
                content.filaName = sb.toString();
                sb.setLength(0);
            } else if (path.charAt(i) == ')') {
                content.text = sb.toString();
                sb.setLength(0);
            } else {
                sb.append(path.charAt(i));
            }
        }
        return content;
    }

    private class Content {
        String filaName;
        String text;
    }
}